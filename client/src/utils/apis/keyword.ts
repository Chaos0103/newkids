import { instance } from './instance';

// 인기 키워드 Top 5 조회
export const findPopularKeywordApi = async () => {
	const response = await instance.get('/keyword-service/popular');
	return response;
};
