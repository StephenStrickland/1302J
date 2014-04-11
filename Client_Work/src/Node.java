

public class Node{
	
	Node left, right, up, down, previous;
	Boolean deadEnd, walked;
	String location;
	ENUM_FROM_DIR fromDir;
	
	public Node()
	{
		left = null;
		right = null;
		up = null;
		down = null;
		deadEnd = false;
	}
	
	public Node(String loc, ENUM_FROM_DIR from, Node prev)
	{
		previous = prev;
		left = null;
		right = null;
		up = null;
		down = null;
		
		location = loc;
		deadEnd = false;
		fromDir = from;
		walked = false;
	}
	public Boolean isWalked()
	{
		return walked;
	}
	
	public ENUM_FROM_DIR getENUM()
	{
		return fromDir;
	}
	
	public Boolean isDead()
	{
		return deadEnd;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public Node getRight()
	{
		return right;
	}
	
	public Node getUp()
	{
		return up;
	}
	
	public Node getDown()
	{
		return down;
	}
	
	public Node getPrevious()
	{
		return previous;
	}
	
	public void setWalked(Boolean newWalk)
	{
		walked = newWalk;
	}
	
	public void setDead(Boolean newdead) 
	{
		deadEnd = newdead;
	}
	
	public void setENUM(ENUM_FROM_DIR newENUM)
	{
		fromDir = newENUM;
	}
	
	public void setLeft(Node newleft)
	{
		left = newleft;
	}
	
	public void setRight(Node newright)
	{
		right = newright;
	}
	
	public void setUp(Node newup)
	{
		up = newup;
	}
	
	public void setDown(Node newdown)
	{
		down = newdown;
	}
	
	public void setPrevious(Node newprev)
	{
		previous = newprev;
	}
	

}
