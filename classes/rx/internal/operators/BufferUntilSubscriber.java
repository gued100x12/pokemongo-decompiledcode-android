package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

public final class BufferUntilSubscriber<T>
  extends Subject<T, T>
{
  private static final Observer EMPTY_OBSERVER = new Observer()
  {
    public void onCompleted() {}
    
    public void onError(Throwable paramAnonymousThrowable) {}
    
    public void onNext(Object paramAnonymousObject) {}
  };
  private boolean forward = false;
  final State<T> state;
  
  private BufferUntilSubscriber(State<T> paramState)
  {
    super(new OnSubscribeAction(paramState));
    this.state = paramState;
  }
  
  public static <T> BufferUntilSubscriber<T> create()
  {
    return new BufferUntilSubscriber(new State());
  }
  
  private void emit(Object paramObject)
  {
    synchronized (this.state.guard)
    {
      this.state.buffer.add(paramObject);
      if ((this.state.observerRef != null) && (!this.state.emitting))
      {
        this.forward = true;
        this.state.emitting = true;
      }
      if (this.forward)
      {
        Object localObject3 = this.state.buffer.poll();
        if (localObject3 != null) {
          this.state.nl.accept(this.state.observerRef, localObject3);
        }
      }
    }
  }
  
  public boolean hasObservers()
  {
    for (;;)
    {
      synchronized (this.state.guard)
      {
        if (this.state.observerRef != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void onCompleted()
  {
    if (this.forward) {
      this.state.observerRef.onCompleted();
    }
    for (;;)
    {
      return;
      emit(this.state.nl.completed());
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.forward) {
      this.state.observerRef.onError(paramThrowable);
    }
    for (;;)
    {
      return;
      emit(this.state.nl.error(paramThrowable));
    }
  }
  
  public void onNext(T paramT)
  {
    if (this.forward) {
      this.state.observerRef.onNext(paramT);
    }
    for (;;)
    {
      return;
      emit(this.state.nl.next(paramT));
    }
  }
  
  static final class OnSubscribeAction<T>
    implements Observable.OnSubscribe<T>
  {
    final BufferUntilSubscriber.State<T> state;
    
    public OnSubscribeAction(BufferUntilSubscriber.State<T> paramState)
    {
      this.state = paramState;
    }
    
    public void call(Subscriber<? super T> paramSubscriber)
    {
      if (this.state.casObserverRef(null, paramSubscriber))
      {
        paramSubscriber.add(Subscriptions.create(new Action0()
        {
          public void call()
          {
            BufferUntilSubscriber.OnSubscribeAction.this.state.observerRef = BufferUntilSubscriber.EMPTY_OBSERVER;
          }
        }));
        int i = 0;
        for (;;)
        {
          synchronized (this.state.guard)
          {
            if (!this.state.emitting)
            {
              this.state.emitting = true;
              i = 1;
            }
            if (i == 0) {
              break;
            }
            NotificationLite localNotificationLite = NotificationLite.instance();
            Object localObject3 = this.state.buffer.poll();
            if (localObject3 != null) {
              localNotificationLite.accept(this.state.observerRef, localObject3);
            }
          }
          synchronized (this.state.guard)
          {
            if (this.state.buffer.isEmpty())
            {
              this.state.emitting = false;
              break;
            }
          }
        }
      }
      paramSubscriber.onError(new IllegalStateException("Only one subscriber allowed!"));
    }
  }
  
  static final class State<T>
  {
    static final AtomicReferenceFieldUpdater<State, Observer> OBSERVER_UPDATER = AtomicReferenceFieldUpdater.newUpdater(State.class, Observer.class, "observerRef");
    final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue();
    boolean emitting = false;
    Object guard = new Object();
    final NotificationLite<T> nl = NotificationLite.instance();
    volatile Observer<? super T> observerRef = null;
    
    boolean casObserverRef(Observer<? super T> paramObserver1, Observer<? super T> paramObserver2)
    {
      return OBSERVER_UPDATER.compareAndSet(this, paramObserver1, paramObserver2);
    }
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/rx/internal/operators/BufferUntilSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */