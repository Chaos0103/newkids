import { PatchWordApiBody, RegistWordApiBody } from 'types/api';
import { instance } from './instance';

// Word

// 단어 등록
export const registWordApi = async (body: RegistWordApiBody) => {
	const response = await instance.post('/words', body);
	return response;
};

// 단어 조회 (간편 사전 검색)
export const findWordByKeywordApi = async (keyword: string, pageNum: number) => {
	const response = await instance.get(`/words?keyword=${keyword}&pageNum=${pageNum}`);
	return response;
};

// 단어 수정
export const patchWordApi = async (wordId: string, body: PatchWordApiBody) => {
	const response = await instance.patch(`/words/${wordId}`, body);
	return response;
};

// 단어 삭제
export const deleteWordApi = async (wordId: string) => {
	const response = await instance.delete(`/words/${wordId}`);
	return response;
};

// Vocabulary

// -- 단어장에 등록
export const registVocabularyApi = async (wordId: string) => {
	const response = await instance.post(`/vocabulary/${wordId}`);
	return response;
};

// -- 단어장에 체크
export const checkVocabularyApi = async (wordId: string) => {
	const response = await instance.patch(`/vocabulary/${wordId}`);
	return response;
};

// -- 단어장에서 삭제
export const deleteVocabularyApi = async (wordId: string) => {
	const response = await instance.delete(`/vocabulary/${wordId}`);
	return response;
};
