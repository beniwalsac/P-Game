import java.util.ArrayList;


public class MasterClientServer {
	public static void main(String[] args) {
		int count = 4;
		ArrayList<PeerNode> arrayOfNodes = createNodes(count);
	}
	
	public static ArrayList<PeerNode> createNodes(int count) {
		System.out.println("Creating a network of "+ count + " nodes...");
        ArrayList< PeerNode > arrayOfNodes = new ArrayList<PeerNode>();

        for(int i=1; i<=count; i++)
        {
            arrayOfNodes.add(new PeerNode(0)); //providing 0, will take any free node
        }
        return arrayOfNodes;
	}
}
