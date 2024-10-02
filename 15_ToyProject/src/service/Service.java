package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
	

	private List<Model> Action = new ArrayList<Model>();
	
	public Service() {
		
		//순서명 : 행동명, 지식증감수치,  건강증감수치, 행복증감수치, 행동설명
		
		Action.add(new Model("먹기",0,0,30,"행복도가 매우 좋아졌다"));   
		Action.add(new Model("휴식",0,25,0,"건강상태가 좋아졌다"));
		Action.add(new Model("잠자기",0,30,30,"행복도와 건강상태가 매우 좋아졌다"));
		
		Action.add(new Model("잠깐 놀기",-5,-5,5,"잠깐 놀아서 기분이 조금 좋아졌다"));
		Action.add(new Model("놀기",-10,-10,10,"놀았기 때문에 성취도가 낮아졌다"));
		Action.add(new Model("격하게 놀기",-20,-20,20,"격하게 놀아서 성취도가 매우 낮아졌다"));
		
		Action.add(new Model("잠깐 공부하기",5,-5,-5,"잠깐 공부하여 지식이 조금 늘었다."));   
		Action.add(new Model("공부하기",10,-10,-10,"공부를 하여 지식이 늘어났다."));
		Action.add(new Model("격하게 공부하기",30,-20,-20,"집중하여 공부를 하였다"));
		Action.add(new Model("카페에서 공부하기",5,0,0,"카페에서 공부하여 지식이 조금 늘었다"));
		Action.add(new Model("학원에서 공부하기",20,0,0,"학원에서 공부하여 지식이 많이 늘었다"));
		Action.add(new Model("집에서 공부하기",5,0,0,"집에서 공부하여 지식이 조금 늘었다"));
		
	}
	
	
	
	Scanner sc = new Scanner(System.in);
	
	public void displaymenu() {
		int menuNum = 0;
		do {
		System.out.println("---- 수강몬 공부시키기 ----\n");
		System.out.println("1. 실행 해보기");
		System.out.println("2. 전체 행동표 조회 ");
		System.out.println("3. 행동 추가 하기 ");
		System.out.println("4. 행동 수정 하기 ");
		System.out.println("5. 행동 삭제 하기 ");
		
		System.out.print("\n입력 : ");
		
		try {
			
			menuNum = sc.nextInt();
			switch (menuNum) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 4: method4(); break;
			case 5: method5(); break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요!");
			}

		} catch (Exception e) {
			System.out.println("\n입력을 확인 하세요(잘못입력)\n");
			sc.nextLine(); 
			menuNum = -1;
		}
		
	} while (menuNum != 0);
		
	}

	public void method1() throws Exception{
		System.out.print("\n당신이 성장시킬 수강몬의 이름 : ");
		String name = sc.next();          // 이름를 받을 스캐너
		
		System.out.print("실행횟수 : ");
		int count = sc.nextInt();          // 반복횟수를 받을 스캐너

		int random = 0;           // 성취도 보조수단(다중결과)   
		int max =0;              // 성취도 보조수단(다중결과)
		
		int days = 0;					 // 행동날짜
		
		int knowledge = 70;             // 학업 성취도
		String k1 = "보통";	     // 출력수단(문자)
		int k2 = 0;              // 출력수단(정수)
		
		int fatigue = 70;               // 피로도
		String f1 = "보통";              // 출력수단(문자)
		int f2 = 0;                   // 출력수단(정수)
		
		int happy = 70;                 // 감정
		String h1 = "보통";               // 출력수단(문자)
		int h2 = 0;                     // 출력수단(정수)
		
		
		String exp = null;              // 행동 설명용
		String action = null;			// 행동명

		String result = null;         // 결과용 1
		String result2 = null;         // 결과용 2
		

		
		System.out.println("\n초기값 " + "건강상태 : " + fatigue + " 학업성취도 : " + knowledge + " 행복도 : " + happy);
		
		for(int i=0; i<count; i++) {
			
			days++;										// 날짜 증가
			max = Action.size();						// 랜덤 선택용
			random = (int)(Math.random() * max); 		// 랜덤 선택용
			
			
			k2 = Action.get(random).getKnow();    // 성취도 수치화
			knowledge = knowledge += k2;          // 증감된 성취도 기록용
			
			
			h2 = Action.get(random).getFeel();
			happy = happy += h2;   
			
			f2 = Action.get(random).getFatigue();
			fatigue = fatigue += f2;   
			
			exp = Action.get(random).getExplanation(); // 설명  랜덤 변환된거 받아오기
			
			action = Action.get(random).getAction();
			
			System.out.println("\n  " + name + "의 상태");
			System.out.printf("┌  %s 은(는) %s 을(를) 선택 !!\n",name,action);
			System.out.println("│  "+exp);
			System.out.printf("└  %d일째  건강상태 : %s  학업성취도 : %s  행복도 : %s \n\n",days,f1,k1,h1);
			
			if(knowledge > 131) {
				k1 = "뛰어남";
				System.out.println("  → " + name+" 은(는) 학습 상태가 매우 좋아보인다.");
			}
			
			if(knowledge >= 100 && knowledge < 130) {
				k1 = "좋음";
			}
			
			else if(knowledge >= 70 && knowledge < 100) {
				k1 = "보통";
			}
			
			else if(knowledge >= 31 && knowledge < 70) {
				k1 = "나쁨";
				System.out.println("  → " + name+" 은(는) 학습상태가 나빠 보인다.");
			}
			else if(knowledge <= 30) {
				k1 = "매우나쁨";
				System.out.println("  → " + name +" 은(는) 학습상태가 매우 나빠보인다.");
			}
			
			
			
			
			if(happy > 131) {
				h1 = "매우 행복함";
			}
			
			if(happy >= 100 && happy < 130) {
				h1 = "행복함";
			}
			
			else if(happy >= 70 && happy < 100) {
				h1 = "보통";
			}
			
			else if(happy >= 31 && happy < 70) {
				h1 = "불행함";
			}
			else if(happy <= 30) {
				h1 = "매우 불행함";
			}
			
			
			
			if(fatigue > 131) {
				f1 = "뛰어남";
				System.out.println("  → " + name+" 은(는) 더이상 휴식이 필요 없어보인다.");
			}
			
			if(fatigue >= 100 && fatigue < 130) {
				f1 = "좋음";
			}
			
			else if(fatigue >= 70 && fatigue < 100) {
				f1 = "보통";
			}
			
			else if(fatigue >= 31 && fatigue < 70) {
				f1 = "나쁨";
				System.out.println("  → " + name+" 은(는) 휴식이 필요해보인다.");
			}
			else if(fatigue <= 30) {
				f1 = "매우나쁨";
				System.out.println("  → " + name +" 은(는) 휴식이 절실하다.");

			}
			
		}
		
		
		if ( fatigue >= 131 && happy >= 131 && knowledge >= 131)
			{ result = "뭐임 어케키움;;;";}
		
		else if	( knowledge >= 100) 
			{ result = "S급 수강몬";}
		
		else if	( knowledge >= 90) 
		{ result = "A급 수강몬";}
		
		else if	( knowledge >= 80) 
		{ result = "B급 수강몬";}
		
		else if	( knowledge >= 70) 
		{ result = "C급 수강몬";}
		
		else if	( knowledge >= 60) 
		{ result = "D급 수강몬";}
		
		else if	( knowledge >= 50) 
		{ result = "E급 수강몬";}
		
		else if	( knowledge >= 11) 
		{ result = "F급 수강몬";}

		else if	( knowledge <= 10) 
		{ result = "폐급 수강몬";
		System.out.println("재수강 고!!!");}
		
		else {result="엥 그 값이 왜 나옴?;;";}
		
		if ( happy > 70 && happy > knowledge) {
			result2 =  "행복하지만 공부는 안한 ";
		} else if (fatigue > 70 && fatigue > knowledge) {
			result2= "건강하지만 공부는 안한 ";
		}
		
		else {result2="";}

		System.out.println("\n\n              ★당신이 키운 " + name+" 은(는) " + result2+ result + "!!!★\n\n");
		
		System.out.println("==================================================================================");
		System.out.println("1번 실행종료====================================================================");
		System.out.println("==================================================================================\n");
	}
	
	public void method2() throws Exception{
		
		System.out.println();
		
		System.out.println("---- 수강몬 행동표 조회 ----\n");
		
		int i = 0;
		
		for(Model find : Action) {
			i++;
			System.out.println(i +". "+ find);
		}
		
		System.out.println("==================================================================================");
		System.out.println("============ 2번 실행종료 ========================================================");
		System.out.println("==================================================================================\n");
		
	}
	
	
	public void method3() throws Exception{
		
		
		System.out.println("\n---- 수강몬 행동 추가하기 ----\n");
		
		System.out.println("제작의도는 행동명 중복을 허용하여 경우의수를 늘리는것 입니다");
		System.out.println("(같은 행동이라도 수치를 다르게 하길 원함)\n");
		
		System.out.print("중복을 허용하여 추가 하시겠습니까? (Y/N)");
		String yn = sc.next();
		String name = null;
		if(yn.equalsIgnoreCase("Y")) {
			System.out.print("\n행동명 : ");
			name = sc.next();
			sc.nextLine(); 
			
			System.out.print("지식증감수치(숫자만 입력) : ");
			int know = sc.nextInt();
			
			System.out.print("건강증감수치(숫자만 입력) : ");
			int Fatigue = sc.nextInt();
			
			System.out.print("건강증감수치(숫자만 입력) : ");
			int feel = sc.nextInt();
			sc.nextLine(); 
			
			System.out.print("행동설명문구 : ");
			String explanation = sc.next();
			
			Model newModel = new Model(name, know, Fatigue, feel, explanation);
			
			Action.add(newModel);
			
			System.out.println("\n  → 행동명 : '" + name + "' 이(가) 정상 추가 되었습니다.\n");
			
			
		} else if(yn.equalsIgnoreCase("N")){
			System.out.print("\n추가할 행동명 : ");
			name = sc.next();

			for(Model find : Action) {
				if(find.getAction().equals(name)) {
					System.out.println("\n행동명 : "+ name + " 은(는) 행동명이 중복됩니다. 삭제후 추가 하세요");
					System.out.println("\n==================================================================================");
					System.out.println("========================== 3번 실행종료 ==========================================");
					System.out.println("==================================================================================\n");
					return;
				}
			}
			for(Model find : Action) {
					if(find.getAction() != name){
					System.out.println("\n행동명 : " + name + " 은(는) 추가 가능 상태 입니다.\n");
					System.out.print("지식증감수치(숫자만 입력) : ");
					int know = sc.nextInt();
					
					System.out.print("건강증감수치(숫자만 입력) : ");
					int Fatigue = sc.nextInt();
					
					System.out.print("건강증감수치(숫자만 입력) : ");
					int feel = sc.nextInt();
					sc.nextLine(); 
					
					System.out.print("행동설명문구 : ");
					String explanation = sc.next();
					
					Model newModel = new Model(name, know, Fatigue, feel, explanation);
					
					Action.add(newModel);
					
					System.out.println("\n  → 행동명 : '" + name + "' 이 정상 추가 되었습니다.");
					System.out.println("\n==================================================================================");
					System.out.println("========================== 3번 실행종료 ==========================================");
					System.out.println("==================================================================================\n");
					return;
				}
			}	
		}else {
			System.out.println("\n입력을 확인 하세요(잘못입력)\n");
		}
	}
	
	public void method4() throws Exception{
		
		
		
		System.out.println("\n---- 수강몬 행동 수정하기 ----\n");
		int i = 0;
		
		for(Model find : Action) {
			i++;
			System.out.println(i +". "+ find);
		}
		
		System.out.println("위 목록표를 확인한뒤");
		System.out.print("수정을 원하는 행동 번호를 입력하세요 : ");
		int y = sc.nextInt(); 
	      
				if(Action.get(y-1) != null ) {
					System.out.println("\n → "+y+". "+Action.get(y-1).getAction()+" 고른상태");
					
					
					System.out.println("\n     1. 행동명");
					System.out.println("     2. 지식증감수치");
					System.out.println("     3. 건강증감수치");
					System.out.println("     4. 행복증감수치");
					System.out.println("     5. 행동 설명 문구");
					System.out.println("     0. 수정 종료");
					
					
					System.out.print("\n어떤 정보를 수정하시겠습니까? 입력 : ");
					
		
					int editMenu=sc.nextInt();
					
					switch(editMenu) {
					case 1 : 
						System.out.println("\n===행동명 수정===");
						System.out.print("수정할 행동명을 입력하세요 : ");
						String action = sc.next();
						System.out.println("\n" + Action.get(y-1).getAction() + " → '"+action+"' (으)로 변경되었다.");
						
						Action.get(y-1).setAction(action);
						break;
					case 2 :
						System.out.println("\n===지식증감수치 수정===");
						System.out.print("수정할 수치를 입력하세요(숫자만 입력) : ");
						int know = sc.nextInt();
						System.out.println("\n" + Action.get(y-1).getKnow()+" → '"+know+"' (으)로 변경되었다.");
						Action.get(y-1).setKnow(know);
						break;
						
					case 3 :
						System.out.println("\n===건강증감수치 수정===");
						System.out.print("수정할 수치를 입력하세요(숫자만 입력) : ");
						int Fatigue = sc.nextInt();
						System.out.println("\n" + Action.get(y-1).getFatigue()+" →'"+Fatigue+"' (으)로 변경되었다.");
						Action.get(y-1).setFatigue(Fatigue);
						break;
						
					case 4 :
						System.out.println("\n===행복증감수치 수정===");
						System.out.print("수정할 수치를 입력하세요(숫자만 입력) : ");
						int feel = sc.nextInt();
						System.out.println("\n" + Action.get(y-1).getFeel()+" → '"+feel+"' (으)로 변경되었다.");
						Action.get(y-1).setFeel(feel);
						break;
						
					case 5 :
						System.out.println("\n===행동설명문구 수정===");
						System.out.print("수정할 문구를 입력하세요 : ");
						String explanation = sc.next();
						System.out.println("\n" + Action.get(y-1).getExplanation()+" → '"+explanation+"' (으)로 변경되었다.");
						Action.get(y-1).setExplanation(explanation);
						break;
						
					case 0 : System.out.println("\n종료합니다\n"); break;
					default : System.out.println("\n입력을 확인 하세요(잘못입력)\n"); break;
					}
				}
				System.out.println("\n==================================================================================");
				System.out.println("======================================== 4번 실행종료 ============================");
				System.out.println("==================================================================================\n");
				
				
	}
	
	public void method5() throws Exception{
		String yn = null;
		
		System.out.println("\n---- 수강몬 행동 삭제하기 ----\n");
		int i = 0;
		
		for(Model find : Action) {
			i++;
			System.out.println(i +". "+ find);
		}
		
		System.out.println("위 목록표를 확인한뒤");
		System.out.print("삭제를 원하는 번호를 입력하세요 : ");
		int y = sc.nextInt(); 
	
		System.out.println("\n →  "+ y + ". " + Action.get(y-1));
		System.out.print("정말 삭제 하겠습니까 (Y/N) : ");
		yn = sc.next();
		
		if(yn.equalsIgnoreCase("Y")) {
			System.out.println("\n"+ y + ". " + Action.get(y-1).getAction() + " 의 정보가 삭제 되었습니다." );
			Action.remove(y-1);
		} else if(yn.equalsIgnoreCase("n")){
			System.out.println("\n" + y + ". " + Action.get(y-1).getAction() +  " 삭제가 취소 되었습니다.");
		}
		System.out.println("\n==================================================================================");
		System.out.println("======================================================= 5번 실행종료 =============");
		System.out.println("==================================================================================\n");
	}
	
}
