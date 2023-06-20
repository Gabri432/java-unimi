package random_programs;

public class Main {
    public static void main(String[] args) {
        RelationSet myRelationSet = new RelationSet();
        myRelationSet.addRelation(1, 1);
        myRelationSet.addRelation(2, 2);
        myRelationSet.addRelation(3, 3);
        System.out.println(myRelationSet);
    }
}
