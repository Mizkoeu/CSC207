//ArrayList implementation
public class ArrayList<T> {
  private Object[] arr;
  private int front;
  public ArrayList() {
    arr = new Object[16];
    front = 0;
  }

  private void ensureCapacity() {
    if (front >= arr.length) {
      arr = Arrays.copyOf(arr, arr.length * 2);
    }
  }

  public add(T v) {
    ensureCapacity();
    arr[front++] = v;
  }
}
