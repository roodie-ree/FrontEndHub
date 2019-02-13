class Robot
  @@available_names = Array.new do |names|
    name = 'AA000'
    names << name
    loop do
      names << name.next!
      break if name == 'ZZ999'
    end
    names.shuffle!
  end
  @@taken_names = Array.new

  def initialize
    @name = nil
  end

  def self.forget
    @@available_names.concat(@@taken_names)
    @@available_names.shuffle!
    @@taken_names.clear
  end

  def self.new_name
    @@taken_names.push(@@available_names.pop())
    @@taken_names.last
  end

  def name
    @name = Robot.new_name if @name.nil?
    @name
  end

  def reset
    @@available_names.push(@name)
    @@taken_names.delete(@name)
    @name = nil
  end
end
