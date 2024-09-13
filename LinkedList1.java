import java.util.*;
class Node
{
int data;
Node next;
 Node(int x)
  {
   data=x;
   next=null;
  }
}
class SingleList
{
Node head,tail;
SingleList()
{
head=tail=null;
}
void create(int x)
{
Node n=new Node(x);
if(head==null)
{
head=tail=n;
}
else
{
tail.next=n;
tail=n;
}
}
void display()
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
void insertFirst(int x)
{
Node n=new Node(x);
if(head==null)
{
head=tail=n;
return;
}
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
int count=2;
while(count<pos&&temp.next!=null)
{
temp=temp.next;
count++;
}
if(temp.next==null)
{
temp.next=n;
tail=n;
}
else
{
n.next=temp.next;
temp.next=n;
}
}
void deleteFirst()
{
if(head==null)
{
System.out.println("List is Empty");
return;
}
Node temp=head;
System.out.println(head.data+" is Deleted.");
head=head.next;
temp.next=null;
}
void deleteLast()
{
if(head==null)
{
System.out.println("List is Empty");
return;
}
Node temp=head;
while(temp.next.next!=null)
 temp=temp.next;
System.out.println(temp.next.data+" is Deleted.");
temp.next=null;
}
void deletePosition(int pos)
{
if(head==null)
{
System.out.println("List is Empty");
return;
}
Node temp=head;
int count=2;
if(temp.next==null)
{
System.out.println(temp.data+" is Deleted.");
head=null;
return;
}
while(temp.next.next!=null&&count<pos)
{
temp=temp.next;
count++;
}
if(temp.next.next==null)
{
System.out.println(temp.next.data+" is Deleted.");
temp.next=null;
tail=temp;
}
else
{
System.out.println(temp.next.data+" is Deleted.");
Node temp1=temp.next;
temp.next=temp.next.next;
temp1.next=null;
}
}
}
class LinkedList1
{
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
SingleList s1=new SingleList();
for(;;)
{
System.out.println("1.Create\n2.Display\n3.Insert First\n4.Insert at position\n5.Delete First\n6.Delete Last\n7.Delete at position\n8.Exit");
System.out.println("Enter the Choice:");
int ch=s.nextInt();
if(ch==1)
{
int x;
System.out.println("Enter the Element:");
x=s.nextInt();
s1.create(x);
}
else if(ch==2)
{
s1.display();
System.out.println();
}
else if(ch==3)
{
int x;
System.out.println("Enter an Element:");
x=s.nextInt();
s1.insertFirst(x);
}
else if(ch==4)
{
int x,pos;
System.out.println("Enter an Element:");
x=s.nextInt();
pos=s.nextInt();
s1.insertPosition(x,pos);
}
else if(ch==5)
{
s1.deleteFirst();
}
else if(ch==6)
{
s1.deleteLast();
}
else if(ch==7)
{
int pos=s.nextInt();
s1.deletePosition(pos);
}
else if(ch==8)
{
break;
}
else
System.out.println("Invalid Choice");
}
}
}