package random_programs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The RelationChecker offers a set of methods to classify the property of a set of relationships. <br /><br />
 * DISCLAIMER: It does <strong>not</strong> guarantee 100% accuracy. I do not recommend using it as a tool for your homeworks.
 */
public class RelationSet {
    public Set<Relation> relations; //The set of relations. Like R = {(a, a), (a, b), ...}.
    public Set<Integer> distinctElements;

    /**
     * A Relation class object represents a relation between two elements a and b.
     */
    public class Relation {
        public final int a;
        public final int b;
        

        /**
         * It creates a relation object.
         * @param a an Integer.
         * @param b an Integer.
         */
        public Relation(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Relation)) {
                return false;
            }
            Relation r = (Relation) obj;
            if (r.a != this.a) return false;
            if (r.b != this.b) return false;
                return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return "(" +  a +", "+ b + ")";
        }
    }

    /**
     * It create a set of relations.
     */
    public RelationSet() {
        Set<Relation> relations = new HashSet<>();
        this.relations = relations;
        Set<Integer> distinctElements = new HashSet<>();
        this.distinctElements = distinctElements;
        /*
        relations.add(new Relation(1, 1)); //(1, 1)
        relations.add(new Relation(2, 2)); //(2, 2)
        relations.add(new Relation(3, 3)); //(3, 3)
        for (var relation : relations) {
            distinctElements.add(relation.a);
            distinctElements.add(relation.b);
        }
        */
    }

    //(x , y) in Set and (y, z) in Set => (x, z) in Set (x, y and z not necessarly different).
    public boolean isTransitive() {
        if (distinctElements.size() < 2) return true; //vacuous truth.
        for (var relation : relations) {
            for (var element : distinctElements) {
                if (relations.contains(new Relation(relation.b, element)) && 
                    !relations.contains(new Relation(relation.a, element))) return false;
            }
        }
        return true;
    }

    //For every x in Set => (x, x) in Set.
    public boolean isReflexive() {
        if (distinctElements.size() < 2) return true; //vacuous truth.
        for (var element : distinctElements) {
            if (!this.relations.contains(new Relation(element, element))) return false;
        }
        return true;
    }

    //For every (x, y) in Set => (y, x) in Set.
    public boolean isSymmetric() {
        if (distinctElements.size() < 2) return true; //vacuous truth.
        for (var relation : relations) {
            if (!relations.contains(new Relation(relation.b, relation.a))) return false;
        }
        return true;
    }

    //For every (x, y) in Set => (y, x) not in Set unless x == y.
    public boolean isAntiSymmetric() {
        if (distinctElements.size() < 2) return true; //vacuous truth.
        for (var relation : relations) {
            if (relations.contains(new Relation(relation.b, relation.a)) &&
               relation.b != relation.a) return false;
        }
        return true;
    }

    public boolean isEquivalence() {
        if (this.isTransitive() && this.isReflexive() && this.isSymmetric()) return true;
        return false;
    }

    public boolean isOrder() {
        if (this.isTransitive() && this.isReflexive() && this.isAntiSymmetric()) return true;
        return false;
    }

    public void addRelation(int a, int b) {
        relations.add(new Relation(a, b));
        for (var relation : relations) {
            distinctElements.add(relation.a);
            distinctElements.add(relation.b);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Is the set: " + relations + ", a\n");
        s.append("symmetric relation? "+ (isSymmetric() ? "Yes" : "no") +"\n");
        s.append("antisymmetric relation? "+ (isAntiSymmetric() ? "Yes" : "no") + "\n");
        s.append("reflexive relation? "+ (isReflexive() ? "Yes" : "no") +"\n");
        s.append("transitive relation? "+ (isTransitive() ? "Yes" : "no") +"\n");
        s.append("equivalence relation? "+ (isEquivalence() ? "Yes" : "no") +"\n");
        s.append("order relation? "+ (isOrder() ? "Yes" : "no") +"\n");
        return s.toString();
    }
}
