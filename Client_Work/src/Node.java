

public class Node{
	
	Node left, right, up, down, previous;
	Boolean deadEnd, walked;
	String location;
	ENUM_FROM_DIR fromDir;
	
	public Node()
	{
		previous = null;
		left = null;
		right = null;
		up = null;
		down = null;
		deadEnd = false;
//		left.setENUM(null);
//		right.setENUM(null);
//		up.setENUM(null);
//		down.setENUM(null);
	}
	
	public Node(String loc, ENUM_FROM_DIR from, Node prev)
	{
		previous = prev;
		left = null;
		right = null;
		up = null;
		down = null;
		
		//left.setENUM(ENUM_FROM_DIR.LEFT);
		//do for the rest of the nodes accordingly.
		
		location = loc;
		deadEnd = false;
		fromDir = from;
		walked = false;
	}
	
	public void createNode(int i)
	{
		switch(i)
		{
			case 1: if (right != null) break; 
				right = new Node();
			this.right.setENUM(ENUM_FROM_DIR.RIGHT);
			this.right.previous = this;
			break;
			case 2:
				if (down != null) break;
				down = new Node();
			this.down.setENUM(ENUM_FROM_DIR.DOWN);
			this.down.previous = this;
			break;
			case 3: 
				if (left != null) break;
				left = new Node();
			this.left.setENUM(ENUM_FROM_DIR.LEFT);
			this.left.previous = this;
			break;
			case 4: 
				if (up !=null) break;
				up = new Node();
			this.up.setENUM(ENUM_FROM_DIR.UP);
			this.up.previous = this;
			break;
		}
		
		
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
	
	public void setLocation(String newLoc)
	{
		location = newLoc;
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
