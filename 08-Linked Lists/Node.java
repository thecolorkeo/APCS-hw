public class Node{
    private String data;
    private Node next;

    public Node(String d){
	data = d;
	next= null;
    }
    public void setData(String d){
	data = d;
    }
    public String getData(){
	return data;
    }
    public void setNext(Node n){
	next = n;
    }
    public Node getNext(){
	return next;
    }
    public String toString(){
	return data;
    }
    /* public static void main(String[]args){
	Node n1= new Node("sully");
	Node n2= new Node("mike");
	n1.setNext(n2);
	n1.getNext().setNext(new Node("Randall"));
	

	System.out.println(n1);
	System.out.println(n1.getNext());
	System.out.println(n1.getNext().getNext());
	System.out.println(n1.getNext().getNext().getNext());
	
	}*/
}