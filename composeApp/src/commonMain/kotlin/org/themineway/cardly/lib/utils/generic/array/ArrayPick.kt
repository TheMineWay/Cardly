package org.themineway.cardly.lib.utils.generic.array

/*
* amount: amount of items to be picked
* startAt: start index
* loop: whether to pick initial items if there are no more behind
**/
fun <T> Iterable<T>.pick(amount: Int, startAt: Int = 0, loop: Boolean = false): List<T> {
    if (this.count() <= 0 || this.count() <= amount) return this.toList();

    val list = mutableListOf<T>();

    var index = startAt;
    while (list.count() < amount) {
        list.add(this.elementAt(index));

        index++;
        if (index >= this.count()) {
            if (loop) index = 0;
            else break;
        }
    }

    return list;
}
