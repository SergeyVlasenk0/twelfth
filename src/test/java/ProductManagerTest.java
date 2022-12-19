import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductManagerTest {
    @Test
    public void testIdNotFound() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Lord of the Rings 1", 150, "Tolkien");
        Book book2 = new Book(2, "Lord of the Rings 2", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the Rings 3", 250, "Tolkien");
        Book book4 = new Book(4, "Witcher", 350, "Sapkowski");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Assertions.assertThrows(NotFoundException.class,
                () -> manager.remove(5));
    }

    @Test
    public void testIdFound() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Lord of the Rings 1", 150, "Tolkien");
        Book book2 = new Book(2, "Lord of the Rings 2", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the Rings 3", 250, "Tolkien");
        Book book4 = new Book(4, "Witcher", 350, "Sapkowski");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.remove(4);

        Product[] actual = manager.searchBy(" ");
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindSomeProducts() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Lord of the Rings 1", 150, "Tolkien");
        Book book2 = new Book(2, "Lord of the Rings 2", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the Rings 3", 250, "Tolkien");
        Book book4 = new Book(4, "Witcher", 350, "Sapkowski");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("Lord");
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testNullProducts() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Lord of the Rings 1", 150, "Tolkien");
        Book book2 = new Book(2, "Lord of the Rings 2", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the Rings 3", 250, "Tolkien");
        Book book4 = new Book(4, "Witcher", 350, "Sapkowski");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("0");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testOneProducts() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Lord of the Rings 1", 150, "Tolkien");
        Book book2 = new Book(2, "Lord of the Rings 2", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the Rings 3", 250, "Tolkien");
        Book book4 = new Book(4, "Witcher", 350, "Sapkowski");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("Witcher");
        Product[] expected = {book4};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemove() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book4 = new Book(4, "Witcher", 350, "Sapkowski");

        manager.add(book4);
        manager.remove(4);

        Product[] actual = manager.searchBy("");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveAll() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Lord of the Rings 1", 150, "Tolkien");
        Book book2 = new Book(2, "Lord of the Rings 2", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the Rings 3", 250, "Tolkien");
        Book book4 = new Book(4, "Witcher", 350, "Sapkowski");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        manager.remove(1);
        manager.remove(2);
        manager.remove(3);
        manager.remove(4);

        Product[] actual = manager.searchBy(" ");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testAuthor() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(1, "Lord of the Rings 1", 150, "Tolkien");
        Book book2 = new Book(2, "Lord of the Rings 2", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the Rings 3", 250, "Tolkien");
        Book book4 = new Book(4, "Witcher", 350, "Sapkowski");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.searchBy("Sapkowski");

        String expected = "Sapkowski";
        String actual = book4.getAuthor();


        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testPrice() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(1, "Lord of the Rings 1", 150, "Tolkien");
        Book book2 = new Book(2, "Lord of the Rings 2", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the Rings 3", 250, "Tolkien");
        Book book4 = new Book(4, "Witcher", 350, "Sapkowski");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.searchBy("Lord of the Rings 1");

        int expected = 150;
        int actual = book1.getPrice();


        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testFindSomeSmarts() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Smartphone smartphone1 = new Smartphone(1,"Smart1", 1000, "Vendor1");
        Smartphone smartphone2 = new Smartphone(2,"Smart2", 1500, "Vendor2");
        Smartphone smartphone3 = new Smartphone(3,"Smart3", 1800, "Vendor3");
        Smartphone smartphone4 = new Smartphone(4,"Smart4", 1100, "Vendor4");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("Smart");
        Product[] expected = {smartphone1, smartphone2, smartphone3, smartphone4};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindVendor() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Smartphone smartphone1 = new Smartphone(1,"Smart1", 1000, "Vendor1");
        Smartphone smartphone2 = new Smartphone(2,"Smart2", 1500, "Vendor2");
        Smartphone smartphone3 = new Smartphone(3,"Smart3", 1800, "Vendor3");
        Smartphone smartphone4 = new Smartphone(4,"Smart4", 1100, "Vendor4");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.searchBy("Smart1");

        String expected = "Vendor1";
        String actual = smartphone1.getVendor();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testFindPriceProduct() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Smartphone smartphone1 = new Smartphone(1,"Smart1", 1000, "Vendor1");
        Smartphone smartphone2 = new Smartphone(2,"Smart2", 1500, "Vendor2");
        Smartphone smartphone3 = new Smartphone(3,"Smart3", 1800, "Vendor3");
        Smartphone smartphone4 = new Smartphone(4,"Smart4", 1100, "Vendor4");
        Book book1 = new Book(1, "Lord of the Rings 1", 150, "Tolkien");
        Book book2 = new Book(2, "Lord of the Rings 2", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the Rings 3", 250, "Tolkien");
        Book book4 = new Book(4, "Witcher", 350, "Sapkowski");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.searchBy("Smart1");

        int expected = 1000;
        int actual = smartphone1.getPrice();
        Assertions.assertEquals(expected, actual);

    }
    }
