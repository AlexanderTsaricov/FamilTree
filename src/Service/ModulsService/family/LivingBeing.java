package Service.ModulsService.family;

public interface LivingBeing<T> {
    int getAge();
    String getName();
    void setParent(T parent);
}
