class BTree( val t: Int,
             var root: Node) {

    fun search(key: Int): Pair<Node, Int>? {
        return root.search(key)
    }
}