package kr.or.connect.BusinessCard;

import java.util.List;
import java.util.Scanner;

import kr.or.connect.BusinessCard.dao.BusinessCardDao;
import kr.or.connect.BusinessCard.dto.BusinessCard;

public class BusinessCardManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int menu = 0;
			System.out.println("--------------------");
			System.out.println("1. 명함 입력");
			System.out.println("2. 명함 검색");
			System.out.println("3. 종료");
			System.out.println("--------------------");
			System.out.print("메뉴를 입력하세요 : ");
			menu = sc.nextInt();

			if(menu == 1) {
				String name = "";
				String phone = "";
				String companyName = "";
				java.sql.Date createDate = new java.sql.Date(new java.util.Date().getTime());
				System.out.print("이름을 입력하세요 : ");
				name = sc.next();
				System.out.print("전화번호를 입력하세요 : ");
				phone = sc.next();
				System.out.print("회사 이름을 입력하세요 : ");
				companyName = sc.next();
				
				BusinessCardDao bcDao = new BusinessCardDao();
				bcDao.setBusinessCard(name, phone, companyName, createDate);
			}
			else if(menu == 2) {
				String name = "";
				List<BusinessCard> bclist = null;
				System.out.print("검색할 이름을 입력하세요 : ");
				name = sc.next();
				BusinessCardDao bcDao = new BusinessCardDao();
				bclist = bcDao.getBusinessCard(name);
				if(bclist.size() == 0) {
					System.out.println("해당 이름을 가진 명함이 없습니다.");
				}
				else {
					for(BusinessCard bc : bclist) {
						System.out.println(bc);
					}
				}
				System.out.println("--------------------------------------------------");
			}
			else if(menu == 3) {
				System.out.println("프로그램을 종료합니다. :-)");
				sc.close();
				return;
			}
			else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
