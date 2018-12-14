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
            false,  arrayListOf(firstNode, secondNode, threeNode)
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
            false,  arrayListOf(firstNode, secondNode, threeNode)
        )
        val tree = BTree(2, root)
        assertNull(tree.search(9))
    }

    @Test
    fun nodeSplit() {
        val exampleFirstNode = Node(3, arrayListOf(2, 3, 4))
        val exampleSecondNode = Node(3, arrayListOf(6, 7, 8))
        val exampleThreeNode = Node(3, arrayListOf(10,11,12))
        val exampleFourNode = Node(1, arrayListOf(0))
        val exampleRoot = Node(
            3, arrayListOf(1, 5, 9),
            false,  arrayListOf(exampleFourNode, exampleFirstNode, exampleSecondNode, exampleThreeNode)
        )

        val splitRoot = Node(7, arrayListOf(2, 3, 4, 5, 6, 7, 8))

        val root = Node(
            2, arrayListOf(1, 9),
            false,  arrayListOf(exampleFourNode, splitRoot, exampleThreeNode)
        )

        splitRoot.splitChild(root, 1, 4)

        assertTrue(root == exampleRoot)
    }
}