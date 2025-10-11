import java.util.*;

class Connection{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        List<Node> graph = new ArrayList<>();
        for(int i=0;i<=v;i++){
            graph.add(new Node(new ArrayList<>(),-1));
        }
        int from,to;
        for(int i=0;i<e;i++){
            from = sc.nextInt();
            to = sc.nextInt();
            graph.get(from).addAdj(to);
            graph.get(to).addAdj(from);
        }
        Queue<Node> q = new LinkedList<>();
        int k =  sc.nextInt();
        int rem = v-k;
        int a,b;
        for(int i=0;i<k;i++){
            a=sc.nextInt();
            b=sc.nextInt();
            graph.get(a).addConfig(b);
            q.add(graph.get(a));
        }
        for(int i=1;i<=v;i++){
            System.out.println("Node: "+i);
            System.out.println("Adj: "+graph.get(i).adj);
            System.out.println("Config: "+graph.get(i).config);
        }
        Node curr;
        int min;
        Node neighbour;
        System.out.println("ANSWER: ");
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i=0;i<curr.adj.size();i++){
                neighbour=graph.get(curr.adj.get(i));
                if(neighbour.config==-1){
                    neighbour.config=curr.config-1;
                    q.add(neighbour);
                }
                else if(Math.abs(neighbour.config-curr.config)!=1){
                    neighbour.config=neighbour.config+2;
                    q.add(neighbour);
                }
            }
        }
        for(int i=1;i<=v;i++){
            // System.out.print("Node: "+i);
            // System.out.println("Adj: "+graph.get(i).adj);
            System.out.println("Config: "+graph.get(i).config);
        }
    }
}

class Node{
    List<Integer> adj;
    int config;
    Node(List<Integer> adj,int config){
        this.adj=adj;
        this.config=config;
    }
    void addAdj(int adj){
        this.adj.add(adj);
    }
    void addConfig(int config){
        this.config=config;
    }
}
