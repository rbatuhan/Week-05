import java.util.TreeSet;

public class Brand implements Comparable<Brand> {
    private int id;
    private String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TreeSet<Brand> brands() {
        TreeSet<Brand> brandsList = new TreeSet<>(Brand::compareTo);
        brandsList.add(new Brand(1, "Samsung"));
        brandsList.add(new Brand(2, "Lenovo"));
        brandsList.add(new Brand(3, "Apple"));
        brandsList.add(new Brand(4, "Huawei"));
        brandsList.add(new Brand(5, "Casper"));
        brandsList.add(new Brand(6, "Asus"));
        brandsList.add(new Brand(7, "HP"));
        brandsList.add(new Brand(8, "Xiaomi"));
        brandsList.add(new Brand(9, "Monster"));
        return brandsList;
    }

    @Override
    public int compareTo(Brand o) {
        return this.name.compareTo(o.getName());
    }

    public static void listBrands(){
        System.out.println("<==== Markalar ====>");
        for (Brand brand : Brand.brands()) {
            System.out.println("- " + brand.getName());
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public static boolean isValidBrand(String brand) {
        for (Brand b : Brand.brands()) {
            if (b.getName().equalsIgnoreCase(brand)) {
                return true;
            }
        }
        return false;
    }
}