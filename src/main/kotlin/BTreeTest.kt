import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BTreeTest {

    @Test
    fun emptyObject() {
        val tree = BTree(2)
        assertTrue(tree == BTree(2))
    }
}