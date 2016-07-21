package manage;

import core.Being;

abstract class AbstractManage<T extends Being> {
    public abstract void add(T b);
    public abstract void delete(int id);
    public abstract void change(int oldId, T toUpdate);
    public abstract void viewAll();
    public abstract void viewOne(int id);
}
