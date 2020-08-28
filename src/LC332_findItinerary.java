import java.util.*;

public class LC332_findItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        LinkedList<String> res = new LinkedList<>();

        if (tickets == null || tickets.size() == 0)
            return res;

        HashMap<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            List<String> near = graph.computeIfAbsent(pair.get(0), k -> new LinkedList<>());
            near.add(pair.get(1));
        }

        graph.values().forEach(k -> k.sort(String::compareTo));
        dfs(graph, "JFK", res);
        return res;
    }

    private void dfs(HashMap<String, List<String>> graph, String FROM, LinkedList<String> res) {
        List<String> near = graph.get(FROM);
        while (near != null && near.size() > 0) {
            String TO = near.remove(0);
            dfs(graph, TO, res);
        }
        res.addFirst(FROM);  // 逆序插入
    }

    public static void main(String[] args) {
        LC332_findItinerary ll = new LC332_findItinerary();

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("MUC");
        list1.add("LHR");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("MUC");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("SFO");
        list3.add("SJC");
        ArrayList<String> list4 = new ArrayList<>();
        list4.add("LHR");
        list4.add("SFO");

        ArrayList<List<String>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        List<String> itinerary = ll.findItinerary(lists);
        System.out.println(itinerary.toString());

    }
}
