import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BTreeTest {

    @Test
    fun emptyObject() {
        val tree = Node(2)
        assertTrue(tree == Node(2))
    }

    @Test
    fun searchKey() {
        val firstNode = Node(2, arrayListOf(1, 2))
        val secondNode = Node(2, arrayListOf(4, 5))
        val threeNode = Node(2, arrayListOf(7, 8))

        val root = Node(
            2, arrayListOf(3, 6),
            false, 3, arrayListOf(firstNode, secondNode, threeNode)
        )

        val tree = BTree(2, root)

        assertEquals(Pair(secondNode, 1), tree.search(5))
    }

    @Test
    fun searchInvalidKey() {
        val firstNode = Node(2, arrayListOf(1, 2))
        val secondNode = Node(2, arrayListOf(4, 5))
        val threeNode = Node(2, arrayListOf(7, 8))

        val root = Node(
            2, arrayListOf(3, 6),
            false, 3, arrayListOf(firstNode, secondNode, threeNode)
        )

        val tree = BTree(2, root)

        assertNull(tree.search(9))
    }
}