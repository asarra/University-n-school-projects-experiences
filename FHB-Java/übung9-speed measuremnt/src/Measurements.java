import java.util.*;

public class Measurements {
    Map<String, String> map = new HashMap<>();
    Collection<Element> hashSet = new HashSet<>();
    Collection<Element> treeSet = new TreeSet<>();
    Collection<Element> arrayList1 = new ArrayList<>();
    Collection<Element> arrayList2 = new ArrayList<>();

    protected void insert(List<Element> elements){
        String name = "Insert";
        map.put(name+"Hash", insertElement(elements, hashSet));
        map.put(name+"Tree", insertElement(elements, treeSet));
        map.put(name+"Array1", insertElement(elements, arrayList1));
        map.put(name+"Array2", insertElement(elements, arrayList2));
    }

    String insertElement(List<Element> elements, Collection<Element> target){
        long start = System.nanoTime();
        for(Element current : elements) target.add(current);
        return (System.nanoTime() - start) + "ns";
    }

    protected void search(List<Element> elements){
        String name = "Search";
        map.put(name+"Hash", searchElement(elements, hashSet));
        map.put(name+"Tree", searchElement(elements, treeSet));
        map.put(name+"Array1", searchElement(elements, arrayList1));
        map.put(name+"Array2", searchElement(elements, arrayList2));
    }

    String searchElement(List<Element> elements, Collection<Element> target){
        long start = System.nanoTime();
        for(Element current : elements) target.contains(current);
        return (System.nanoTime() - start) + "ns";
    }

    protected void delete(List<Element> elements){
        String name = "Delete";
        map.put(name+"Hash", deleteElement(elements, hashSet));
        map.put(name+"Tree", deleteElement(elements, treeSet));
        map.put(name+"Array1", deleteElement(elements, arrayList1));
        map.put(name+"Array2", deleteElement(elements, arrayList2));
    }

    String deleteElement(List<Element> elements, Collection<Element> target){
        long start = System.nanoTime();
        for(Element current : elements) target.remove(current);
        return (System.nanoTime() - start) + "ns";
    }

    @Override
    public String toString() {
        String insertString = "--- Insert ---\n"+"HashSet: "+map.get("InsertHash")+"\n" + "TreeSet: "+map.get("InsertTree")+"\n" + "ArrayList1: "+map.get("InsertArray1")+"\n" + "ArrayList2: "+map.get("InsertArray2")+"\n";
        String searchString = "--- Search ---\n"+"HashSet: "+map.get("SearchHash")+"\n" + "TreeSet: "+map.get("SearchTree")+"\n" + "ArrayList1: "+map.get("SearchArray1")+"\n" + "ArrayList2: "+map.get("SearchArray2")+"\n";
        String deleteString = "--- Delete ---\n"+"HashSet: "+map.get("DeleteHash")+"\n" + "TreeSet: "+map.get("DeleteTree")+"\n" + "ArrayList1: "+map.get("DeleteArray1")+"\n" + "ArrayList2: "+map.get("DeleteArray2")+"\n";
        return insertString+searchString+deleteString;
    }
}
