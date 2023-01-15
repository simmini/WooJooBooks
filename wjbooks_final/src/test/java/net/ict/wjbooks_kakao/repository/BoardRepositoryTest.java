//package net.ict.wjbooks_kakao.repository;
//
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import net.ict.wjbooks.constant.SellCondition;
//import net.ict.wjbooks.constant.SellStatus;
//import net.ict.wjbooks.domain.Board;
//import net.ict.wjbooks.domain.QBoard;
//import net.ict.wjbooks_kakao.constant.SellCondition;
//import net.ict.wjbooks_kakao.constant.SellStatus;
//import net.ict.wjbooks_kakao.domain.Board;
//import net.ict.wjbooks_kakao.domain.SellBoard;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//import com.querydsl.core.BooleanBuilder;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.thymeleaf.util.StringUtils;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestPropertySource(locations = "classpath:application-test.properties")
//class BoardRepositoryTest {
//    @PersistenceContext
//    EntityManager em;
//    @Autowired
//    BoardRepository boardRepository;
//
//    @Test
//    @DisplayName("게시글 저장 테스트")
//    public void createBoardTest(){
//        SellBoard board = new SellBoard();
//        board.setSellTitle("판매 게시글 제목");
//        board.setSellContent("판매 게시글 내용");
//        board.setSellPrice(15000);
//        board.setSellStatus(SellStatus.SALE);
//        board.setSellCondition(SellCondition.OLD);
//        board.setSellView(1L);
//        board.setBookTitle("도깨비");
//        board.setBookPublisher("끝방삼촌출판사");
//        board.setBookWriter("김신");
//        board.setBookDate("2017-10-10");
//        board.setBookPrice(32000);
//        board.setCategory_a("드라마원작소설");
//        board.setCategory_b("로맨스소설");
//        Board savedBoard = boardRepository.save(board);
//        System.out.println(savedBoard.toString());
//    }
//    public void createBoardList(){
//        for(int i = 1; i<=10 ; i++){
//            Board board = new Board();
//            board.setSellTitle("판매 게시글 제목"+i);
//            board.setSellContent("판매 게시글 내용"+i);
//            board.setSellPrice(15000+i);
//            board.setSellStatus(SellStatus.SALE);
//            board.setSellCondition(SellCondition.OLD);
//            board.setSellView(1L);
//            board.setBookTitle("도깨비"+i);
//            board.setBookPublisher("끝방삼촌출판사"+i);
//            board.setBookWriter("김신"+i);
//            board.setBookDate("2017-10-10"+i);
//            board.setBookPrice(32000);
//            board.setCategory_a("드라마원작소설"+i);
//            board.setCategory_b("로맨스소설"+i);
//            Board savedBoard = boardRepository.save(board);
//        }
//    }
//    @Test
//    @DisplayName("게시물 명 조회 테스트")
//    public void findBySellTitleTest(){
//        this.createBoardList();
//        List<Board> boardList = boardRepository.findBySellTitle("판매 게시글 제목1");
//        for(Board board : boardList){
//            System.out.println(board.toString());
//        }
//    }
//    @Test
//    @DisplayName("게시글명, 책제목 or 테스트")
//    public void findBySellTitleOrBookTitleTest(){
//        this.createBoardList();
//        List<Board> boardList=boardRepository.findBySellTitleOrBookTitle("판매 게시글 제목1", "도깨비4");
//        for(Board board : boardList){
//            System.out.println(board.toString());
//        }
//    }
//
//    @Test
//    @DisplayName("가격 LessThan 테스트")
//    public void findBySellPriceLessThanTest(){
//        this.createBoardList();
//        List<Board> boardList = boardRepository.findBySellPriceLessThan(15004);
//        for(Board board : boardList){
//            System.out.println(board.toString());
//        }
//    }
//    @Test
//    @DisplayName("가격 LessThan 테스트")
//    public void findBySellPriceLessThanOrderBySellPriceDesc(){
//        this.createBoardList();
//        List<Board> boardList = boardRepository.findBySellPriceLessThanOrderBySellPriceDesc(15004);
//        for(Board board : boardList){
//            System.out.println(board.toString());
//        }
//    }
//
//    @Test
//    @DisplayName("@Query 를 이용한 상품 조회 테스트")
//    public void findByBookTitleTest(){
//        this.createBoardList();
//        List<Board> boardList = boardRepository.findByBookTitle("도깨비3");
//        for(Board board : boardList){
//            System.out.println(board.toString());
//        }
//    }
//
//    @Test
//    @DisplayName("Querydsl 조회테스트1")
//    public void queryDslTest(){
//        this.createBoardList();
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//        QBoard qBoard = QBoard.board;
//        JPAQuery<Board> query = queryFactory.selectFrom(qBoard)
//                .where(qBoard.sellStatus.eq(SellStatus.SALE))
//                .where(qBoard.bookTitle.like("%"+"깨비"+"%"))
//                .orderBy(qBoard.sellPrice.desc());
//
//        List<Board> boardList=query.fetch();
//
//        for(Board board : boardList){
//            System.out.println(board.toString());
//        }
//    }
//
//    public void createBoardList2(){
//        for(int i=1;i<=5;i++){
//            Board board = new Board();
//            board.setSellTitle("판매 게시글 제목"+i);
//            board.setSellContent("판매 게시글 내용"+i);
//            board.setSellPrice(15000+i);
//            board.setSellStatus(SellStatus.SALE);
//            board.setSellCondition(SellCondition.OLD);
//            board.setSellView(1L);
//            board.setBookTitle("도깨비"+i);
//            board.setBookPublisher("끝방삼촌출판사"+i);
//            board.setBookWriter("김신"+i);
//            board.setBookDate("2017-10-10"+i);
//            board.setBookPrice(32000);
//            board.setCategory_a("드라마원작소설"+i);
//            board.setCategory_b("로맨스소설"+i);
//            Board savedBoard = boardRepository.save(board);
//        }
//        for(int i=6;i<=10;i++){
//            Board board = new Board();
//            board.setSellTitle("판매 게시글 제목"+i);
//            board.setSellContent("판매 게시글 내용"+i);
//            board.setSellPrice(15000+i);
//            board.setSellStatus(SellStatus.SOLD_OUT);
//            board.setSellCondition(SellCondition.OLD);
//            board.setSellView(1L);
//            board.setBookTitle("도깨비"+i);
//            board.setBookPublisher("끝방삼촌출판사"+i);
//            board.setBookWriter("김신"+i);
//            board.setBookDate("2017-10-10"+i);
//            board.setBookPrice(32000);
//            board.setCategory_a("드라마원작소설"+i);
//            board.setCategory_b("로맨스소설"+i);
//            Board savedBoard = boardRepository.save(board);
//        }
//    }
//    @Test
//    @DisplayName("상품 Querydsl 조회 테스트 2")
//    public void queryDslTest2(){
//        this.createBoardList2();
//
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//        QBoard board = QBoard.board;
//        String sellTitle = "판매 게시글 제목";
//        Integer price = 15003;
//        String sellStatus="SALE";
//
//        booleanBuilder.and(board.sellTitle.like("%"+sellTitle+"%"));
//        booleanBuilder.and(board.sellPrice.gt(price));
//
//        if(StringUtils.equals(sellStatus, SellStatus.SALE)){
//            booleanBuilder.and(board.sellStatus.eq(SellStatus.SALE));
//        }
//        Pageable pageable = PageRequest.of(0,5);
//        Page<Board> boardPagingResult = boardRepository.findAll(booleanBuilder,pageable);
//        System.out.println("total elements : "+boardPagingResult.getTotalElements());
//
//        List<Board> resultBoardList = boardPagingResult.getContent();
//        for(Board resultBoard : resultBoardList){
//            System.out.println(resultBoard.toString());
//        }
//    }
//}