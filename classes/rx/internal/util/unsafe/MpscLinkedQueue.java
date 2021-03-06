package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;
import sun.misc.Unsafe;

public final class MpscLinkedQueue<E>
  extends BaseLinkedQueue<E>
{
  public MpscLinkedQueue()
  {
    this.consumerNode = new LinkedQueueNode();
    xchgProducerNode(this.consumerNode);
  }
  
  public final boolean offer(E paramE)
  {
    if (paramE == null) {
      throw new IllegalArgumentException("null elements not allowed");
    }
    LinkedQueueNode localLinkedQueueNode = new LinkedQueueNode(paramE);
    xchgProducerNode(localLinkedQueueNode).soNext(localLinkedQueueNode);
    return true;
  }
  
  public final E peek()
  {
    LinkedQueueNode localLinkedQueueNode1 = this.consumerNode;
    LinkedQueueNode localLinkedQueueNode2 = localLinkedQueueNode1.lvNext();
    Object localObject;
    if (localLinkedQueueNode2 != null) {
      localObject = localLinkedQueueNode2.lpValue();
    }
    for (;;)
    {
      return (E)localObject;
      if (localLinkedQueueNode1 != lvProducerNode())
      {
        LinkedQueueNode localLinkedQueueNode3;
        do
        {
          localLinkedQueueNode3 = localLinkedQueueNode1.lvNext();
        } while (localLinkedQueueNode3 == null);
        localObject = localLinkedQueueNode3.lpValue();
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public final E poll()
  {
    LinkedQueueNode localLinkedQueueNode1 = lpConsumerNode();
    LinkedQueueNode localLinkedQueueNode2 = localLinkedQueueNode1.lvNext();
    Object localObject;
    if (localLinkedQueueNode2 != null)
    {
      localObject = localLinkedQueueNode2.getAndNullValue();
      spConsumerNode(localLinkedQueueNode2);
    }
    for (;;)
    {
      return (E)localObject;
      if (localLinkedQueueNode1 != lvProducerNode())
      {
        LinkedQueueNode localLinkedQueueNode3;
        do
        {
          localLinkedQueueNode3 = localLinkedQueueNode1.lvNext();
        } while (localLinkedQueueNode3 == null);
        localObject = localLinkedQueueNode3.getAndNullValue();
        this.consumerNode = localLinkedQueueNode3;
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  protected final LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    LinkedQueueNode localLinkedQueueNode;
    do
    {
      localLinkedQueueNode = this.producerNode;
    } while (!UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, localLinkedQueueNode, paramLinkedQueueNode));
    return (LinkedQueueNode)localLinkedQueueNode;
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/rx/internal/util/unsafe/MpscLinkedQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */