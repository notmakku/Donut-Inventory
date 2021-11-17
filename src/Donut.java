@Entity
@Data @NoArgsConstructor
public class Donut {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DonutToppings toppings;

    public String name;
    public Double costDollars;
    public Integer numberAvailable;

    Donut(String name, DonutToppings toppings, Double costDollars, Integer numberAvailable) {
        this.name = name;
        this.toppings = toppings;
        this.costDollars = costDollars;
        this.numberAvailable = numberAvailable;
    }
}
public enum DonutToppings {

    CHOCOLATE("Chocolate Icing"),
    SPRINKLES("Sprinkles"),
    MAPLE("Maple Icing"),
    GLAZED("Sugar Glaze"),
    BACON("Bacon"),
    POWDERED_SUGAR("Powdered Sugar"),
    NONE("None");

    private final String value;

    DonutToppings(String value) {
        this.value = value;
    }

}