import { RegistReadArticleApiBody } from 'types/api';
import { instance } from './instance';

// 기사 전체 조회 (기사 검색)
export const getAllArticleApi = async () => {
	const response = await instance.get('/article-service');
	return response;
};

// 기사 상세 조회
export const getArticleApi = async (articleId: number) => {
	const response = await instance.get(`/articles/${articleId}`);
	return response;
};

// 기사 상세 조회
export const deleteArticleApi = async (articleId: number) => {
	const response = await instance.delete(`/articles/${articleId}`);
	return response;
};

// 읽은 뉴스기사 등록
export const registReadArticleApi = async (body: RegistReadArticleApiBody, memberKey: string) => {
	const response = await instance.post(`/article-service/read/${memberKey}`, body);
	return response;
};

// 읽은 뉴스기사 조회
export const findAllReadArticleApi = async (memberKey: string) => {
	const response = await instance.get(`/article-service/read/${memberKey}`);
	return response;
};

// 읽은 뉴스기사 조회
export const deleteReadArticleApi = async (articleId: number) => {
	const response = await instance.delete(`/article-service/read/${articleId}`);
	return response;
};

// 기사 읽기 (TODO)
export const readArticleApi = async (articleId: number) => {
	const response = await instance.get(`/articles/${articleId}`);
	return response;
};
