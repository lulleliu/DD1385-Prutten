public class main {

    public static void main(String[] args) {
        Composite suitcase = new Composite("Suitcase", 10000);
        Composite toilet_bag = new Composite("Toilet bag", 200);
        Composite stuff = new Composite("Bag with stuff", 100);
        stuff.add(new Leaf("Pokemon card, Charizard", 5));
        stuff.add(new Leaf("Pokemon card, Lucario lvl X", 5));
        stuff.add(new Leaf("Pokemon card, Dark Slowbro", 5));
        stuff.add(new Leaf("Pokemon card, Aron", 5));
        stuff.add(new Leaf("Condom from 2011", 15));

        toilet_bag.add(stuff);
        toilet_bag.add(new Leaf("Tooth paste", 150));
        toilet_bag.add(new Leaf("Unused Deo", 150));

        suitcase.add(toilet_bag);
        suitcase.add(new Leaf("Shirt", 300));
        Leaf jeans = new Leaf("Jeans", 1000);
        suitcase.add(jeans);
        
        System.out.println(suitcase.toString());
        System.out.println("-----------------------------");
        System.out.println("total weight: " + suitcase.getWeight() + " grams");
        
        System.out.println("-----------------------------");
        System.out.println("Removing toiletbag...");
        suitcase.remove(toilet_bag);
        System.out.println("-----------------------------");

        System.out.println("New items in suitcase");
        System.out.println(suitcase.toString());
        System.out.println("New total weight: " + suitcase.getWeight() + " grams");

        System.out.println("-----------------------------");
        System.out.println("Removing jeans...");
        suitcase.remove(jeans);
        System.out.println("-----------------------------");

        System.out.println("New items in suitcase");
        System.out.println(suitcase.toString());
        System.out.println("New total weight: " + suitcase.getWeight() + " grams");


        //DepthFirstIterator dfs = new DepthFirstIterator(suitcase);
        //dfs.next();

    }
}
