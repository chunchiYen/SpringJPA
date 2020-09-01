

1.使用原生JPARepository
2.使用EntityManager (此EntityManager為共用，只能讀取資料庫資料無法做更新、刪除)
3.從LocalSessionFactory取得EntityManagerFactory, 再取得EntityManager做資料crud動作
crud需放置在EntityManager.getTransaction().gebein()、EntityManager.getTransaction().commit()之間，且
EntityManager需close()，否則太屏繁會塞住
4.HibernateUtil取的SessionFactory  ,再從SessionFactory.openSession()取得session, 使用session做資料查詢