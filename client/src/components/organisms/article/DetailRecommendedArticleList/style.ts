import styled from 'styled-components';

export const DetailRecommendedArticleListContainer = styled.div`
	margin-top: 3rem;
	display: flex;
	flex-direction: column;
	gap: 1rem;

	.list-items {
		display: flex;
		gap: 1rem;

		div {
			img {
				height: 150px;
			}

			h2 {
				color: white;
				bottom: 0;
				position: absolute;
				z-index: 11;
				font-size: 1rem;
				margin: 1rem;
				white-space: normal;
				display: -webkit-box;
				-webkit-line-clamp: 2;
				-webkit-box-orient: vertical;
				overflow: hidden;
				transition: all 0.1s;
			}

			&:hover {
				h2 {
					transform: translateY(-20%);
				}
			}
		}
	}
`;
