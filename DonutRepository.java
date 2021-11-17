public interface DonutRepository extends CrudRepository<Donut, Long> {
    List<Donut> findByNameIgnoreCase(String name);
}