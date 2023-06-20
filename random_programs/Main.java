package random_programs;

public class Main {
    public static void main(String[] args) {
        RelationSet myRelationSet = new RelationSet();
        myRelationSet.addRelation(1, 2);
        myRelationSet.addRelation(2, 3);
        myRelationSet.addRelation(1, 3);
        System.out.println(myRelationSet);
    }
}
