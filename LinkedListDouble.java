import java.util.*;
class Node
{
 	int data;
 	Node prev,next;
 	Node(int x)
 	{
  		data=x;
  		prev=next=null;
 	}
}
class DoubleList
{
	Node head,tail;
	DoubleList()
	{
		head=tail=null;
	}
	void create(int x)
	{
		Node n=new Node(x);
		if(head==null)
		{
			head=tail=n;
			return;
		}
		tail.next=n;
		n.prev=tail;
		tail=n;
	}
	void rshow()
	{
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	void lshow()
	{
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
		Node temp=tail;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.prev;
		}
	}
	void insertFirst(int x)
	{
		Node n=new Node(x);
		if(head==null)
		{
			head=tail=n;
			return;
		}
		head.prev=n;
		n.next=head;
		head=n;
	}
	void insertPosition(int x,int pos)
	{
		Node n=new Node(x);
		if(head==null)
		{
			head=tail=n;
			return;
		}
		Node temp=head;
		int count=1;
		while(count<pos&&temp.next!=null)
		{
			count++;
			temp=temp.next;
		}
		if(temp.next==null)
		{
			temp.next=n;
			n.prev=temp;
			tail=n;
		}
		else
		{
			n.next=temp;
			n.prev=temp.prev;		
			temp.prev.next=n;
			temp.prev=n;
		}
	}
	void deleteFirst()
	{
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
		if(head.next==null)
		{
			System.out.println(head.data+" is deleted");
			head=tail=null;
		}
		else
		{
			System.out.println(head.data+" is deleted");
			head.next.prev=null;
			head=head.next;
		}
	}
	void deleteLast()
	{
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
		if(head.next==null)
		{
			System.out.println(head.data+" is deleted");
			head=tail=null;
		}
		else
		{
			Node temp=tail;
			temp.prev.next=null;
			tail=temp.prev;
			temp=null;
		}
	}
	void deletePosition(int pos)
	{
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
		Node temp=head;
		int count=1;
		while(count<pos&&temp.next!=null)
		{
			count=count+1;
			temp=temp.next;
		}
		if(temp.next==null)
		{
			System.out.println(temp.data+" is deleted");
			temp.prev.next=null;
			tail=temp.prev;
			temp=null;
		}
		else
		{
			System.out.println(temp.data+" is deleted");
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
			temp=null;
		}
			
	}	
}
class LinkedListDouble
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		DoubleList d=new DoubleList();
		for(;;)
		{
			System.out.println();
			System.out.println("1.Create\n2.Print\n3.Insertion at First\n4.Insertion at Any position\n5.Delete at Firat\n6.Delete at Last\n7.Delete at any Position\n8.Exit");
			int ch;
         		System.out.println("Enter the Choice:");
			ch=s.nextInt();
			if(ch==1)
			{
				int x;
				System.out.println("Enter an Element:");
				x=s.nextInt();
				d.create(x);
			}
			else if(ch==2)
			{
				System.out.println("Enter the Traversal direction:\n1.Forward\n2.Backward");
				int r=s.nextInt();
				if(r==1)
				{
					d.rshow();
				}
				else if(r==2)
				{
					d.lshow();
				}
				else
					System.out.println("Invalid traversal");
			}
			else if(ch==3)
			{
				System.out.println("Enter an element:");
				int x=s.nextInt();
				d.insertFirst(x);
			}
			else if(ch==4)
			{
				System.out.println("Enter an Element");
				int x=s.nextInt();
				System.out.print("Enter the Position:");
				int pos=s.nextInt();
				d.insertPosition(x,pos);
			}
			else if(ch==5)
			{
				d.deleteFirst();
			}
			else if(ch==6)
			{
				d.deleteLast();
			}
			else if(ch==7)
			{
				int pos;
				System.out.println("Enter Position:");
				pos=s.nextInt();
				d.deletePosition(pos);
			}
			else if(ch==8)
				break;
			else
				System.out.println("Invalid Choice");
		}
	}
}
		
  