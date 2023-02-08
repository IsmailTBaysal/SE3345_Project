
public class LinkedList<AnyType extends IDedObject> {

    //Header Node
    private Node start;
    //Size of list
    private int size;

    public LinkedList(){
        start = null;
        size = 0;
    }

    public void makeEmpty(){
        start = null;
        size = 0;
    }

    public boolean insertAtFront(AnyType x){

        Node node = new Node(x, null);


        if(start == null){
            start = node;
            size++;
            return true;
        }

        Node ptr = start;

        while(ptr!=null){

            if(ptr.getData().getID() == x.getID()){
                return false;
            }
            else{
                ptr = ptr.getLink();
            }
        }

        node.setLink(start);
        start = node;
        size++;

        return true;
    }


    public AnyType findID(int ID){
        Node nptr = start;

        while(nptr!=null){
            if(nptr.getData().getID() == ID){
                return nptr.getData();
            }
            else{
                nptr = nptr.getLink();
            }
        }

        return null;
    }


    public AnyType deleteFromFront(){

        if(start == null){
            return null;
        }

        AnyType x = start.getData();
        start = start.getLink();
        size--;
        return x;
    }


    public AnyType delete(int ID){

        if(start == null)
            return null;

        if(start.getData().getID() == ID){
            AnyType x = start.getData();
            start = start.getLink();
            size--;
            return x;
        }

        AnyType x = null;
        Node ptr = start;
        Node nptr = start.getLink();

        while(nptr!=null){
            if(nptr.getData().getID() == ID){
                x=nptr.getData();
                ptr.setLink(nptr.getLink());
                size--;
                break;
            }
            else{
                ptr = nptr;
                nptr = nptr.getLink();
            }

        }
        return x;
    }


    public void printAllRecords(){

        if(start==null){
            System.out.println("List is empty");
        }

        Node nptr = start;

        while(nptr!=null){
            nptr.getData().printID();
            nptr = nptr.getLink();
        }
    }


    class Node{

        private AnyType data;
        //Link to next node
        private Node link;

        Node(AnyType data, Node link){
            this.data = data;
            this.link = link;
        }

        public AnyType getData() {
            return data;
        }

        public void setData(AnyType data) {
            this.data = data;
        }

        public Node getLink() {
            return link;
        }

        public void setLink(Node link) {
            this.link = link;
        }


    }
}