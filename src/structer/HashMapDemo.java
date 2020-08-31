package structer;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(7);
        Emp emp1 = new Emp(1, "Tom");
        hashMap.add(emp1);
//        hashMap.show();
        int emp = hashMap.findNumOfArr(1);
        System.out.println(emp);
    }


}
    class HashMap {
        EmpLinkedList[] empHashMapArr;
        int size;

        public HashMap(int size) {
            this.size = size;
            empHashMapArr = new EmpLinkedList[size];
            for (int i = 0; i < size; i++) {
                empHashMapArr[i] = new EmpLinkedList();
            }
        }

        public void add(Emp emp) {
            int num = findNumOfArr(emp.id);
            empHashMapArr[num].add(emp);
        }

        public void show() {
            for (int i = 0; i < size; i++) {
                empHashMapArr[i].show();
            }
        }
        public Emp findById(int id){
            Emp emp = empHashMapArr[findNumOfArr(id)].findById(id);
            if (emp == null){
                System.out.println("没有找到id对应用户");
                return null;
            }
            return emp;
        }

        public int findNumOfArr(int id) {
            return id % size;
        }
    }

    class EmpLinkedList {
        private Emp head;

        public void add(Emp emp) {
            if (head == null) {
                head = emp;
                return;
            }
            Emp cur = head;
            while (true) {
                if (cur.next == null) {
                    cur.next = emp;
                    break;
                }
                cur = cur.next;
            }

        }
        public Emp findById(int id){
            if (head == null){
                System.out.println("链表为空，找不到id所属用户");
                return null;
            }
            Emp cur = head;
            while (true){
                if (cur.id == id){
                    break;
                }
                if (cur.next == null){
                    cur = null;
                    return cur;
                }
                cur = cur.next;
            }
            return cur;
        }
        public void show() {
            if (head == null) {
                System.out.println("链表为空");
                return;
            }
            Emp cur = head;
            while (true) {
                if (cur == null) {
                    break;
                }
                System.out.println("id = " + cur.id + "name = " + cur.name);
                cur = cur.next;
            }

        }
    }

    class Emp {
        public int id;
        public String name;
        public Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
