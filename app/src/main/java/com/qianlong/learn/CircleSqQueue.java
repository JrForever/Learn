package com.qianlong.learn;

public class CircleSqQueue implements IQueue{
    private Object[] queueElem;//队列存储空间
    private int front;//队首引用，若队列不为空，指向队首元素
    private int rear;//队尾引用，若队列不为空，指向队尾的下一个元素
    public CircleSqQueue(int maxsize) {
        front=rear=0;
        queueElem=new Object[maxsize];//分配maxsize个单元
    }
    @Override
    public void clear() {
        front=rear=0;
    }
    @Override
    public boolean isEmpty() {
        return rear==front;
    }
    @Override
    public int length() {
        return (rear-front+queueElem.length)%queueElem.length;
    }
    @Override
    public Object peek() {
        if(front==rear){
            return null;
        }
        else{
            return queueElem[front];
        }
    }
    @Override
    public void offer(Object x) throws Exception {
        if((rear+1)%queueElem.length==front){//队满
            throw new Exception("队列已满");
        }
        else{
            queueElem[rear]=x;
            rear=(rear+1)%queueElem.length;//修改队尾指针
        }
    }
    @Override
    public Object poll() {
        if(front==rear){
            return null;//队列为空
        }
        else{
            Object t=queueElem[front];
            front=(front+1)%queueElem.length;
            return t;
        }
    }
    @Override
    public void display() {
        if(!isEmpty()){
            for(int i=front;i!=rear;i=(i+1)%queueElem.length){
                System.out.println(queueElem[i].toString()+" ");
            }
        }
        else{
            System.out.println("此队列为空");
        }
    }
}
