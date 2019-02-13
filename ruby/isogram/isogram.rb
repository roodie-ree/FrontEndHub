class Isogram
  def self.isogram?(input)
    cleaned = input.gsub(/[ -]/, '').downcase
    for char in cleaned.each_char do
      return false if cleaned.each_char.count(char) > 1
    end
  end
end
