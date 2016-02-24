package mcts.state

import org.scalatest.{FunSuite, FunSpec}

/**
  * Created by culim on 2/24/16.
  */
class TestOXOState extends FunSuite{

    test("A newly created OXOState should just have an 3 x 3 board.") {
        val state : OXOState = new OXOState
        assert(state.board.length == 9)
    }

    test("A newly created OXOState should be completely empty.") {
        val state : OXOState = new OXOState
        val nonZeroes : Array[Int] = state.board.filter(x => x > 0)
        assert(nonZeroes.length == 0)
    }

    test("A newly created OXOState should have its lastPlayerWhoMoved value as player 2.") {
        val state : OXOState = new OXOState
        assert(state.getLastPlayerWhoMoved == 2)
    }

    test("A newly created OXOState should yield a result of zero for both player 1 and 2.") {
        val state : OXOState = new OXOState
        assert(state.getResult(1)==0)
        assert(state.getResult(2)==0)
    }

    test("A newly created OXOState should have all indices [0..8] as available actions.") {
        val state : OXOState = new OXOState
        var expected : Set[Int] = Set(0, 1, 2, 3, 4, 5, 6, 7, 8)
        val actual : Set[Int] = state.getAvailableActions

        assert(expected.equals(actual), s"expected=\n${expected};\nactual=\n${actual}")
    }

    test("A newly created OXOState should have a correct toString() representation.") {
        val state : OXOState = new OXOState
        val actual : String = state.toString
        var expected : String = "...\n...\n...\n"
        assert(expected.equals(actual), s"expected=\n${expected}; actual=\n${actual}")
    }

    test("After player 1 makes a move on index=0, OXOState should have correct string representation.") {
        val state : OXOState = new OXOState
        state.doAction(0)
        val actual : String = state.toString
        var expected : String = "O..\n...\n...\n"
        assert(expected.equals(actual), s"expected=\n${expected}; actual=\n${actual}")
    }

    test("After player 1 makes a move on index=0, and player 2 makes a move on index=8, OXOState should have correct string representation.") {
        val state : OXOState = new OXOState
        state.doAction(0)
        state.doAction(8)
        val actual : String = state.toString
        var expected : String = "O..\n...\n..X\n"
        assert(expected.equals(actual), s"expected=\n${expected}; actual=\n${actual}")
    }

}
