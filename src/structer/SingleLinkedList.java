package structer;


import java.util.List;
import java.util.Stack;

class SingleLinkedListDemo {


    public static void main(String[] args) throws Exception {
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode1 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode2 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(4, "林冲", "豹子头");
        HeroNode heroNode4 = new HeroNode(5, "刘备", "5");
//        HeroNode heroNode5 = new HeroNode(6, "张飞", "6");
//        HeroNode updateNode = new HeroNode(5, "李逵", "黑旋风");
        SingleLinkedList list = new SingleLinkedList();
//        list.add(heroNode);
//        list.add(heroNode1);
//        list.add(heroNode2);
//        list.add(heroNode3);
//        list.add(heroNode5);
//        list.addForOrder(heroNode4);
//        list.addForOrder(heroNode4);
//        list.showList();

        list.addForOrder(heroNode1);
        list.addForOrder(heroNode4);
        list.addForOrder(heroNode2);
        list.addForOrder(heroNode3);
        list.addForOrder(heroNode);
        HeroNode newNode = heroNode3;
        newNode.next = heroNode;
        newNode = heroNode2;
        newNode.next = heroNode4;
//        list.showList();
//        System.out.println("---------------------------");
//        list.reverse(list.getHead());
//        list.showList();
//        System.out.println("--------------------------------------------");
//        list.update(updateNode);
//        list.showList();
//        System.out.println("---------------------------------------------");
//        list.delete(2);
//        list.showList();
    }
}

class SingleLinkedList{
    //初始化一个头节点
    private HeroNode head = new HeroNode(0,"","");


    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        //因为添加是添加在链表最后，所以需要遍历链表看有多少个节点，又因为head节点不能动，所以需要一个temp节点替代head

        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addForOrder(HeroNode heroNode){

        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                temp.next = heroNode;
            }
            if (temp.next.no > heroNode.no){
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            }
            if (temp.next.no == heroNode.no){
                System.out.println("准备添加的英雄编号" + heroNode.no+"已经存在！");
                break;
            }
            temp = temp.next;
        }
    }
    public void update(HeroNode heroNode){
        if (head.next == null){
            return;
        }
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == heroNode.no){
                temp.next.name = heroNode.name;
                temp.next.nickName = heroNode.nickName;
            }
            temp = temp.next;
        }
    }

    public void delete(int num) throws Exception {
        if (head.next == null){
            throw new  Exception("链表为空");
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next.no == num) {
                temp.next = temp.next.next;
                break;
            }
            if (temp.next == null){
                System.out.println("没有找到目标人物");
            }
            temp = temp.next;
        }
    }

    public void showList(){
        //不管是显示数组队列还是链表，首先都要判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        //遍历链表
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public void reverse(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;

        }
        head.next = reverseHead.next;
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//注意，如果将类里的属性设置为私有，则在其他类中无法调用本类的属性
    public HeroNode(int no,String name,String nickName){

        this.no = no;
        this.name = name;
        this.nickName = nickName;

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
