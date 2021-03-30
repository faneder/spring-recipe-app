package guru.springframework.datastructureandalgorithms.fundamentalDataStructures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SinglyLinkedListTest {

    @Test
    void shouldCountSizeWhenAddItem() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.addFirst("first item");

        assertThat(singlyLinkedList.getSize()).isEqualTo(1);
    }

    @Test
    void shouldAddItemToTheFrontOfLinkedList() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        String item = "first item";

        singlyLinkedList.addFirst(item);

        assertThat(singlyLinkedList.getFirst()).isEqualTo(item);
    }

    @Test
    void shouldAddItemToTheLastOfLinkedList() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        String item = "last item";

        singlyLinkedList.addLast(item);

        assertThat(singlyLinkedList.getLast()).isEqualTo(item);
    }

    @Test
    void shouldRemoveFirstItem() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.addFirst("item 1");
        singlyLinkedList.addLast("item 2");
        singlyLinkedList.removeFirst();

        assertThat(singlyLinkedList.getFirst()).isEqualTo("item 2");
    }
}