package Week14;

public class BinaryTreeArrayMain21 {
    public static void main(String[] args) {
        BinaryTreeArray21 bta = new BinaryTreeArray21();
        Student21 m1 = new Student21("244107020138", "Devin", "TI-1I", 3.57);
        Student21 m2 = new Student21("244107020023", "Dewi", "TI-1I", 3.85);
        Student21 m3 = new Student21("244107020225", "Wahyu", "TI-1I", 3.21);
        Student21 m4 = new Student21("244107020076", "Angelina", "TI-1I", 3.54);
        Student21 m5 = new Student21("244107020223", "Andhika", "TI-1I", 3.72);
        Student21 m6 = new Student21("244107020226", "Bima", "TI-1I", 3.37);
        Student21 m7 = new Student21("244107020181", "Eiyu", "TI-1I", 3.46);

        Student21[] data = {m1, m2, m3, m4, m5, m6, m7};
        bta.populateData(data, data.length-1);
        System.out.println("In-Order traversal:");
        bta.traverseInOrder(0);

        bta.add(new Student21("244107020114", "Norawit", "TI-1I", 3.93));
        bta.add(new Student21("244107010411", "Nattawat", "TI-1I", 3.97));
        bta.add(new Student21("244107010129", "Naya", "TI-1I", 3.90));

        bta.traversePreOrder();
    }
}