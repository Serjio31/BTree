import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BTreeTest {

    @Test
    fun emptyObject() {
        val tree = BTree(2)
        assertTrue(tree == BTree(2))
    }

    @Test
    fun searchKey() {
        val firstTree = BTree(2, 2, arrayListOf(1, 2))
        val secondTree = BTree(2, 2, arrayListOf(4, 5))
        val threeTree = BTree(2, 2, arrayListOf(7, 8))

        val tree = BTree(
            2, 2, arrayListOf(3, 6),
            false, 3, arrayListOf(firstTree, secondTree, threeTree)
        )
        assertEquals(Pair(secondTree, 1), tree.search(5))
    }

    @Test
    fun searchInvalidKey() {
        val firstTree = BTree(2, 2, arrayListOf(1, 2))
        val secondTree = BTree(2, 2, arrayListOf(4, 5))
        val threeTree = BTree(2, 2, arrayListOf(7, 8))

        val tree = BTree(
            2, 2, arrayListOf(3, 6),
            false, 3, arrayListOf(firstTree, secondTree, threeTree)
        )
        assertNull(tree.search(9))
    }
}