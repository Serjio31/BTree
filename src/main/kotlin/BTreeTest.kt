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
            false, arrayListOf(firstNode, secondNode, threeNode)
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
            false, arrayListOf(firstNode, secondNode, threeNode)
        )
        val tree = BTree(2, root)
        assertNull(tree.search(9))
    }

    @Test
    fun nodeSplit() {
        val exampleFirstNode = Node(3, arrayListOf(2, 3, 4))
        val exampleSecondNode = Node(3, arrayListOf(6, 7, 8))
        val exampleThreeNode = Node(3, arrayListOf(10, 11, 12))
        val exampleFourNode = Node(1, arrayListOf(0))
        val exampleRoot = Node(
            3, arrayListOf(1, 5, 9),
            false, arrayListOf(exampleFourNode, exampleFirstNode, exampleSecondNode, exampleThreeNode)
        )

        val splitRoot = Node(7, arrayListOf(2, 3, 4, 5, 6, 7, 8))

        val root = Node(
            2, arrayListOf(1, 9),
            false, arrayListOf(exampleFourNode, splitRoot, exampleThreeNode)
        )

        splitRoot.splitChild(root, 1, 4)

        assertTrue(root == exampleRoot)
    }

    @Test
    fun insertNonFull() {
        val exampleFirstNode = Node(2, arrayListOf(1, 3))
        val exampleSecondNode = Node(1, arrayListOf(6))
        val exampleThreeNode = Node(2, arrayListOf(8, 9))
        val exampleFourNode = Node(2, arrayListOf(11, 12))
        val exampleRoot = Node(
            3, arrayListOf(5, 7, 10),
            false, arrayListOf(exampleFirstNode, exampleSecondNode, exampleThreeNode, exampleFourNode)
        )

        val root = Node(
            2, arrayListOf(5, 10),
            false, arrayListOf(exampleFirstNode, Node(3, arrayListOf(6, 7, 9)), exampleFourNode)
        )

        root.insertNonFull(8, 2)

        assertTrue(root == exampleRoot)
    }

    @Test
    fun insertIntoTree() {
        val exampleFirstNode = Node(3, arrayListOf(1, 3, 5))
        val exampleSecondNode = Node(4, arrayListOf(9,10,11,13))

        val exampleRoot = Node(
            1, arrayListOf(7),
            false, arrayListOf(exampleFirstNode, exampleSecondNode)
        )
        val tree = BTree(4, Node(7, arrayListOf(1,3,5,7,9,11,13)))
        tree.insert(10)
        assertTrue(tree.root == exampleRoot)
    }

    @Test
    fun deleteFromTree() {
        val exampleFirstNode = Node(3, arrayListOf(1, 3, 5))
        val exampleSecondNode = Node(3, arrayListOf(10,11,13))

        val exampleRoot = Node(
            1, arrayListOf(9),
            false, arrayListOf(exampleFirstNode, exampleSecondNode)
        )
        val tree = BTree(4, Node(1, arrayListOf(7),
            false, arrayListOf(exampleFirstNode, Node(4, arrayListOf(9, 10,11,13))) ))
        tree.delete(7)
        assertTrue(tree.root == exampleRoot)
    }


}