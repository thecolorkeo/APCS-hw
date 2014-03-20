public class MyLinkedList{
    private Node tail;
    private Node head;

    public MyLinkedList(){
	tail = null;
	head = null;
    }
    public void add(String d){
	if (head == null){
	    Node tmp = new Node(d);
	    head = tmp;
	}else if(tail == null){
	    Node tmp = new Node(d);
	    head.setNext(tmp); //you must do this first
	    tail = tmp; //you must do this second
	}else{
	    Node tmp = new Node(d);
	    tail.setNext(tmp); //you must do this first
	    tail = tmp; //you must do this second
	}
    }
    public void add(int i, String d){
	Node addition = new Node(d);
	if (head.getData() == null || i == 1){
	    Node tmp = new Node(d);
	    head = tmp;
	}else{
	    Node tmp = new Node(head.getData());
	    tmp.setNext(head.getNext());
	    for(int j = 0; j < i-1; j++){	    
		tmp = tmp.getNext();
	    }
	    tmp.setNext(addition);
	    tmp.getNext().setData(addition.getData());
	    tmp.getNext().setNext(tmp.getNext().getNext());
	}
    }
    public String toString(){			
	String result = "";
	Node tmp = new Node(head.getData());
	tmp.setNext(head.getNext());
	while (tmp.getNext() != null){
	    result += tmp.getData();
	    result += ", ";
	    tmp = tmp.getNext();
	}	
	if(tail != null){
	    result += tail.getData();
	}
	return result;
    }
    public String get(int i){
	Node tmp = new Node(head.getData());
	tmp.setNext(head.getNext());
	for(int j = 0; j < i; j++){
	   tmp = tmp.getNext();
	}
	return tmp.getData();
    }
    public int find(String s){
	Node tmp = new Node(head.getData());
	tmp.setNext(head.getNext());
	int i = 0;
	int result = -1;
	while(tmp.getNext() != null){
	    if (tmp.getData() == s){
	        result = i;
		i++;
		tmp = tmp.getNext();
	    }else{
		i++;
		tmp = tmp.getNext();
	    }
	}
	return result;
    }
    public String remove(int i){
	String r = "";
	for(int j = 0; j < i-1; j++){
	    head = head.getNext();
	}
	r = head.getNext().getData();
        head.setNext(head.getNext().getNext());
	return r;
	
    }
    public String set(int i, String s){
	Node tmp = new Node(head.getData());
	tmp.setNext(head.getNext());
	String r = "";
	for(int j = 0; j < i-1; j++){
	    tmp = tmp.getNext();
	}
	r = tmp.getNext().getData();
        tmp.getNext().setData(s);
	return r;	
    }
    public int length(){
	Node tmp = new Node(head.getData());
	tmp.setNext(head.getNext());
	int i = 1;
	while(tmp.getNext() != null){
	    tmp = tmp.getNext();
	    i++;
	}
	return i;
    }
    public static void main(String[]args){
	MyLinkedList L= new MyLinkedList();
	L.add("Sully");
	L.add("Mike");
	L.add("Randall");
	L.add("Boo");
	L.add("Boo");
	L.add("Boo");
	System.out.println(L);
	System.out.println(L.remove(1));
	System.out.println(L.toString());
	System.out.println(L.set(4, "joey"));
	System.out.println(L.toString());
	System.out.println(L.get(0));
	System.out.println(L.length());
	System.out.println(L.find("Boo"));
    }
}
