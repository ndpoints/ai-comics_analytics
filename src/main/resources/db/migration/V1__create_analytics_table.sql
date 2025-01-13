CREATE TABLE analytics (
    analytics_id INTEGER NOT NULL UNIQUE,
    comic_id INTEGER NOT NULL,
    views INTEGER NOT NULL,
    likes INTEGER NOT NULL,
    shares INTEGER NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    PRIMARY KEY (analytics_id)
);

CREATE INDEX idx_comic_id ON analytics(comic_id);

INSERT INTO analytics (analytics_id, comic_id, views, likes, shares, created_at) VALUES
(1, 101, 100, 10, 5, NOW()),
(2, 102, 150, 20, 10, NOW()),
(3, 103, 200, 30, 15, NOW());