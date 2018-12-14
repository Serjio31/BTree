import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class BTreeTest {

    @Test
    fun `EmptyObject`() {
        val tree = BTree()
        assertTrue(tree == BTree())
    }
}