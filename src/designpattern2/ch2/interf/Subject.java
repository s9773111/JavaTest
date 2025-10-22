package designpattern2.ch2.interf;

/**
 * Subject的介面
 * 當其狀態改變時，這個方法會被呼叫
 * 藉以通知所有觀察者
 *
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
