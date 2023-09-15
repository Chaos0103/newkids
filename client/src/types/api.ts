// REQUEST

// -- auth :: 로그인 body
export interface LoginApiBody {
	email: string;
	password: string;
}

// -- auth :: 회원가입 body
export interface JoinApiBody {
	email: string;
	password: string;
	name: string;
	age: number;
	nickname: string;
}

//  -- auth :: 이메일 중복 검증 body
export interface CheckEmailApiBody {
	email: string;
}

//  -- auth :: 닉네임 중복 검증 body
export interface CheckNicknameApiBody {
	nickname: string;
}

// -- auth :: 비밀번호 변경
export interface PatchPasswordApiBody {
	currentPwd: string;
	newPwd: string;
}

// -- word :: 단어 등록
export interface RegistWordApiBody {
	wordKey: string;
	word: string;
	description: string;
}

// -- word :: 단어 등록
export interface PatchWordApiBody {
	word: string;
	description: string;
}

// -- article :: 읽은 뉴스기사 등록
export interface RegistReadArticleApiBody {
	articleId: number;
}

// RESPONSE
