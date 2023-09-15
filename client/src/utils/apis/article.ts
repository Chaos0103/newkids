import { instance } from './instance';

// 기사 전체 조회 (기사 검색)
export const getAllArticleApi = async (keyword: string, term: string, pageNum: number) => {
	const response = await instance.get(`/articles?keyword=${keyword}&term=${term}&pageNum=${pageNum}`);
	return response;
};

// 기사 상세 조회
export const getArticleApi = async (articleId: number) => {
	const response = await instance.get(`/articles/${articleId}`);
	return response;
};

// 기사 읽기 (TODO)
export const readArticleApi = async (articleId: number) => {
	const response = await instance.get(`/articles/${articleId}`);
	return response;
};
