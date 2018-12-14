class BTree(
    val t: Int,
    var root: Node
) {

    fun search(key: Int): Pair<Node, Int>? {
        return root.search(key)
    }

    fun insert(k: Int) {
        if (root.keysCount == 2 * this.t - 1) {
            val s = Node()
            s.isLeaf = false
            s.nodes.add(root)
            root.splitChild(s, 0, this.t)
            root = s
            s.insertNonFull(k, this.t)
        } else {
            root.insertNonFull(k, this.t)
        }
    }
}