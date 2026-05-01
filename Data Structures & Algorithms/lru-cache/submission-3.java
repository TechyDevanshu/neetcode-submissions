class LRUCache {

    class Node{
        int key,value;
        Node next,prev;

        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    Map<Integer,Node>map;
    private final int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head= new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    public void insert(Node node){
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }

    public void remove(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
        }

        Node node= new Node(key,value);
        insert(node);
        map.put(key,node);

        if(map.size()>capacity){
            Node lru=tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
